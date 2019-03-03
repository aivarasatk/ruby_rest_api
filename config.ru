ENV['RACK_ENV'] = "production"

require './sinatra_test.rb'

run Sinatra::Application