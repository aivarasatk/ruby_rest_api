#!/bin/bash
echo -ne "\e[36mCreating a user-based network bridge\e[39m"
docker network create ws_bridge
echo -e "\e[36m. Done.\e[39m\e[K"
cd NotesApi
echo -e "\e[36mCreating a user-based network bridge. Done.\e[39m"
echo -e "\e[36mLaunching user service\e[39m"
docker-compose up --build --force-recreate -d
echo -e "\e[36mLaunching user service. Done.\e[39m"
cd ..
echo -e "\e[?1049h"
echo -e "\e[36mCreating a user-based network bridge. Done.\e[39m"
echo -e "\e[36mLaunching user service. Done.\e[39m"
docker-compose up --build --force-recreate -d
echo -e "\e[36mLaunching service. Done.\e[39m"
echo -e "\e[32mReady\e[39m"