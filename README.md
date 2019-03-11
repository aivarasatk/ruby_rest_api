# ruby_rest_api
A project for a web services

Possible prerequisites:
ruby
sudo apt-get install build-essential patch ruby-dev zlib1g-dev liblzma-dev
sudo apt-get install make
sudo gem install thin
sudo gem install sinatra
sudo gem install json

lauch the the app with this line(locally(ports must be forwarded to 8080))(from root):
thin -R config.ru start -e production -p 8080


Image file:

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