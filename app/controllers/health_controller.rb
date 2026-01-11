class HealthController < ApplicationController
  def index
    render json: { status: 'ok', message: 'WeightLossHelper API is running' }
  end
end
