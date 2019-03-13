# ruby_rest_api
A project for a web services

## Clone the app
git clone https://github.com/aivarasatk/ruby_rest_api.git <br>
## Create docker image:
sudo docker build -t ruby-image -f ruby-thin-image .

## Run docker image:

sudo docker run -d -p 80:5000 ruby-image

## Access the app
(change the port to match your machine) <br>
url/languages

POST url/languages
GET url/languages
PUT url/languages/id
DELETE url/languages/id

