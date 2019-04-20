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