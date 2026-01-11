Rails.application.routes.draw do
  namespace :api do
    namespace :v1 do
      resources :people do
        member do
          get :bmi
        end
      end
      resources :children

      post 'weight/convert', to: 'weight#convert'

      # Calorie tracking endpoints
      post 'calories/track', to: 'calories#track'
      post 'calories/search', to: 'calories#search'
      post 'calories/daily_needs', to: 'calories#daily_needs'
    end
  end

  get 'health', to: 'health#index'
end
