class Child < Person
  validates :previous_height, numericality: { greater_than: 0 }, allow_nil: true
  validates :current_height, numericality: { greater_than: 0 }, allow_nil: true

  # Calculate growth rate as the difference between current and previous height
  def calculate_growth_rate
    return nil if previous_height.nil? || current_height.nil?
    current_height - previous_height
  end

  # Calculate growth percentage
  def growth_percentage
    return nil if previous_height.nil? || current_height.nil? || previous_height.zero?
    ((current_height - previous_height) / previous_height * 100).round(2)
  end
end
