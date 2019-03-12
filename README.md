# ruby_rest_api
A project for a web services

## Create docker image:

sudo docker build -t ruby-image -f ruby-thin-image .

## Run docker image:

sudo docker run -d -p 80:5000 ruby-image

## Access the app
(change the port to match your machine) <br>
http://193.219.91.103:6725/languages

# dev:

thin -R config.ru start -e production -p 8080


## Image file:

FROM alpine:latest

RUN apk update && apk upgrade &&  apk add --update ruby-dev build-base \
  libxml2-dev libxslt-dev pcre-dev libffi-dev \
  mariadb-dev postgresql-dev

RUN apk add ruby ruby-bundler

RUN mkdir /usr/app
WORKDIR /usr/app

COPY . /usr/app

RUN bundle install

CMD ["thin", "-R", "config.ru", "start", "-e", "production", "-p", "5000"]
