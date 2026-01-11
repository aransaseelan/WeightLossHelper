module Api
  module V1
    class PeopleController < ApplicationController
      before_action :set_person, only: [:show, :update, :destroy, :bmi]

      # GET /api/v1/people
      def index
        @people = Person.where(type: nil)
        render json: @people
      end

      # GET /api/v1/people/:id
      def show
        render json: @person
      end

      # POST /api/v1/people
      def create
        @person = Person.new(person_params)

        if @person.save
          render json: @person, status: :created
        else
          render json: { errors: @person.errors.full_messages }, status: :unprocessable_entity
        end
      end

      # PATCH/PUT /api/v1/people/:id
      def update
        if @person.update(person_params)
          render json: @person
        else
          render json: { errors: @person.errors.full_messages }, status: :unprocessable_entity
        end
      end

      # DELETE /api/v1/people/:id
      def destroy
        @person.destroy
        head :no_content
      end

      # GET /api/v1/people/:id/bmi
      def bmi
        bmi_value = @person.calculate_bmi
        render json: {
          person_id: @person.id,
          name: @person.name,
          weight_pounds: @person.weight,
          weight_kg: @person.weight_in_kg,
          height_meters: @person.height,
          bmi: bmi_value,
          category: @person.bmi_category
        }
      end

      private

      def set_person
        @person = Person.find(params[:id])
      rescue ActiveRecord::RecordNotFound
        render json: { error: 'Person not found' }, status: :not_found
      end

      def person_params
        params.require(:person).permit(:name, :age, :gender, :weight, :height)
      end
    end
  end
end
