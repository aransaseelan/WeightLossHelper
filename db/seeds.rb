# Create sample people for testing
Person.create!(
  name: 'John Doe',
  age: 30,
  gender: 'male',
  weight: 180.0,  # pounds
  height: 1.75    # meters
)

Person.create!(
  name: 'Jane Smith',
  age: 25,
  gender: 'female',
  weight: 140.0,
  height: 1.65
)

Child.create!(
  name: 'Tommy Doe',
  age: 10,
  gender: 'male',
  weight: 70.0,
  height: 1.35,
  previous_height: 1.30,
  current_height: 1.35
)

puts "Seeded #{Person.count} people (including #{Child.count} children)"
