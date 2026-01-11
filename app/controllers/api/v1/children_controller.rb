module Api
  module V1
    class ChildrenController < ApplicationController
      before_action :set_child, only: [:show, :update, :destroy]

      # GET /api/v1/children
      def index
        @children = Child.all
        render json: @children
      end

      # GET /api/v1/children/:id
      def show
        render json: child_with_growth(@child)
      end

      # POST /api/v1/children
      def create
        @child = Child.new(child_params)

        if @child.save
          render json: child_with_growth(@child), status: :created
        else
          render json: { errors: @child.errors.full_messages }, status: :unprocessable_entity
        end
      end

      # PATCH/PUT /api/v1/children/:id
      def update
        if @child.update(child_params)
          render json: child_with_growth(@child)
        else
          render json: { errors: @child.errors.full_messages }, status: :unprocessable_entity
        end
      end

      # DELETE /api/v1/children/:id
      def destroy
        @child.destroy
        head :no_content
      end

      private

      def set_child
        @child = Child.find(params[:id])
      rescue ActiveRecord::RecordNotFound
        render json: { error: 'Child not found' }, status: :not_found
      end

      def child_params
        params.require(:child).permit(:name, :age, :gender, :weight, :height, :previous_height, :current_height)
      end

      def child_with_growth(child)
        {
          id: child.id,
          name: child.name,
          age: child.age,
          gender: child.gender,
          weight: child.weight,
          height: child.height,
          previous_height: child.previous_height,
          current_height: child.current_height,
          growth_rate: child.calculate_growth_rate,
          growth_percentage: child.growth_percentage,
          bmi: child.calculate_bmi,
          bmi_category: child.bmi_category
        }
      end
    end
  end
end
