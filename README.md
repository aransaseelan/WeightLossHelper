# WeightLossHelper

A Ruby on Rails API backend that helps you healthily lose weight over a period of time.

## Features

* **BMI Calculator**: Calculate and track your Body Mass Index
* **Weight Conversion**: Convert between pounds and kilograms
* **Growth Tracking**: Monitor children's growth rate over time
* **Calorie Tracking**: Framework for nutrition API integration (coming soon)
* **Daily Calorie Needs**: Calculate your recommended daily calorie intake

## Tech Stack

* Ruby on Rails 7.1 (API mode)
* SQLite database
* RESTful API design

## Setup

1. Install Ruby 3.0+ and Bundler
2. Install dependencies:
   ```bash
   bundle install
   ```
3. Setup the database:
   ```bash
   bin/rails db:create db:migrate db:seed
   ```
4. Start the server:
   ```bash
   bin/rails server
   ```

## API Endpoints

### Health Check
- `GET /health` - Check if API is running

### People
- `GET /api/v1/people` - List all people
- `POST /api/v1/people` - Create a person
- `GET /api/v1/people/:id` - Get a person
- `PATCH /api/v1/people/:id` - Update a person
- `DELETE /api/v1/people/:id` - Delete a person
- `GET /api/v1/people/:id/bmi` - Get BMI calculation for a person

### Children
- `GET /api/v1/children` - List all children
- `POST /api/v1/children` - Create a child (with growth tracking)
- `GET /api/v1/children/:id` - Get a child with growth rate
- `PATCH /api/v1/children/:id` - Update a child
- `DELETE /api/v1/children/:id` - Delete a child

### Weight Conversion
- `POST /api/v1/weight/convert` - Convert weight between units
  - Parameters: `value`, `from` (pounds/kg), `to` (kg/pounds)

### Calorie Tracking
- `POST /api/v1/calories/track` - Track food calories
- `POST /api/v1/calories/search` - Search for foods
- `POST /api/v1/calories/daily_needs` - Calculate daily calorie needs

## Example Usage

```bash
# Create a person
curl -X POST http://localhost:3000/api/v1/people \
  -H "Content-Type: application/json" \
  -d '{"person": {"name": "John", "age": 30, "gender": "male", "weight": 180, "height": 1.75}}'

# Get BMI
curl http://localhost:3000/api/v1/people/1/bmi

# Convert weight
curl -X POST http://localhost:3000/api/v1/weight/convert \
  -H "Content-Type: application/json" \
  -d '{"value": 180, "from": "pounds", "to": "kg"}'
```
