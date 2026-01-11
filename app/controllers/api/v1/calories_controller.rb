module Api
  module V1
    class CaloriesController < ApplicationController
      # POST /api/v1/calories/track
      def track
        result = CalorieTracker.track(
          food_name: params[:food_name],
          quantity: params[:quantity] || 1,
          unit: params[:unit] || 'serving'
        )

        render json: result
      end

      # POST /api/v1/calories/search
      def search
        result = CalorieTracker.search(query: params[:query])
        render json: result
      end

      # POST /api/v1/calories/daily_needs
      def daily_needs
        result = CalorieTracker.calculate_daily_needs(
          weight_kg: params[:weight_kg].to_f,
          height_cm: params[:height_cm].to_f,
          age: params[:age].to_i,
          gender: params[:gender],
          activity_level: params[:activity_level] || 'moderate'
        )

        render json: result
      end
    end
  end
end
