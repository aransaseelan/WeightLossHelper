class Person < ApplicationRecord
  validates :name, presence: true
  validates :age, presence: true, numericality: { only_integer: true, greater_than: 0 }
  validates :gender, presence: true
  validates :weight, presence: true, numericality: { greater_than: 0 }
  validates :height, numericality: { greater_than: 0 }, allow_nil: true

  # Calculate BMI using weight in kg and height in meters
  # Formula: BMI = weight_kg / (height_m ^ 2)
  def calculate_bmi(weight_kg = nil, height_m = nil)
    w = weight_kg || weight_in_kg
    h = height_m || height

    return nil if w.nil? || h.nil? || h.zero?

    (w / (h ** 2)).round(2)
  end

  # Convert weight from pounds to kilograms
  def weight_in_kg
    return nil if weight.nil?
    WeightCalculator.pounds_to_kg(weight)
  end

  # Get BMI category based on calculated BMI
  def bmi_category
    bmi = calculate_bmi
    return nil if bmi.nil?

    case bmi
    when 0...18.5
      'Underweight'
    when 18.5...25
      'Normal weight'
    when 25...30
      'Overweight'
    else
      'Obese'
    end
  end
end
