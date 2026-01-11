module Api
  module V1
    class WeightController < ApplicationController
      # POST /api/v1/weight/convert
      def convert
        value = params[:value].to_f
        from_unit = params[:from]&.downcase
        to_unit = params[:to]&.downcase

        result = case [from_unit, to_unit]
                 when ['pounds', 'kg'], ['lbs', 'kg']
                   { value: value, from: 'pounds', to: 'kg', result: WeightCalculator.pounds_to_kg(value) }
                 when ['kg', 'pounds'], ['kg', 'lbs']
                   { value: value, from: 'kg', to: 'pounds', result: WeightCalculator.kg_to_pounds(value) }
                 else
                   { error: 'Invalid conversion. Supported: pounds<->kg' }
                 end

        if result[:error]
          render json: result, status: :unprocessable_entity
        else
          render json: result
        end
      end
    end
  end
end
