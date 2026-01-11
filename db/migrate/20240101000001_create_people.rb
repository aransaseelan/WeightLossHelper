class CreatePeople < ActiveRecord::Migration[7.1]
  def change
    create_table :people do |t|
      t.string :name, null: false
      t.integer :age, null: false
      t.string :gender, null: false
      t.float :weight, null: false  # Weight in pounds
      t.float :height              # Height in meters
      t.string :type               # For STI (Single Table Inheritance) with Child

      # Child-specific fields
      t.float :previous_height
      t.float :current_height

      t.timestamps
    end

    add_index :people, :type
  end
end
