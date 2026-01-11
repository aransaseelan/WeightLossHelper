class WeightCalculator
  # Conversion factor from pounds to kilograms
  POUNDS_TO_KG_FACTOR = 0.45359237

  # Conversion factor from kilograms to pounds
  KG_TO_POUNDS_FACTOR = 2.20462262

  class << self
    # Convert weight from pounds to kilograms
    def pounds_to_kg(weight_pounds)
      return nil if weight_pounds.nil?
      (weight_pounds * POUNDS_TO_KG_FACTOR).round(4)
    end

    # Convert weight from kilograms to pounds
    def kg_to_pounds(weight_kg)
      return nil if weight_kg.nil?
      (weight_kg * KG_TO_POUNDS_FACTOR).round(4)
    end

    # Convert height from feet/inches to meters
    def feet_inches_to_meters(feet, inches = 0)
      return nil if feet.nil?
      total_inches = (feet * 12) + (inches || 0)
      (total_inches * 0.0254).round(4)
    end

    # Convert height from meters to feet/inches
    def meters_to_feet_inches(meters)
      return nil if meters.nil?
      total_inches = meters / 0.0254
      feet = (total_inches / 12).floor
      inches = (total_inches % 12).round(1)
      { feet: feet, inches: inches }
    end
  end
end
