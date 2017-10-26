#!/bin/bash

###output function
output_green () {
    green=`tput setaf 2`
    reset=`tput sgr0`
    word=$1
    
    echo $green $word $reset
}

output_red () {
    red=`tput setaf 1`
    reset=`tput sgr0`
    word=$1
    
    echo $red $word $reset
}

output_green "### One Script Shall Install Them All ###"
output_green "### Start Add PPA and do upgrade first###"
sudo apt-get update
sudo add-apt-repository ppa:ondrej/php -y
##sudo apt-get -y upgrade

output_green "### Update ###"
sudo apt-get update

output_green "### Install zsh ###"
sudo apt-get -qy install terminator
sudo apt-get -qy install zsh
sudo chsh -s $(which zsh)
output_green "### Install CURL & Oh My Zsh! ###"
sudo apt-get -y install curl wget
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"

output_green "### Install PHP ###"
sudo apt-get -qy install php \
    php-mysql \
    php-soap \
    php-mbstring \
    php-mcrypt \
    php-mongodb \
    php-cli \
    php-xml \
    php-zip \
    php-tokenizer \
    php-pdo \

output_green "### Install Composer ###"
EXPECTED_SIGNATURE=$(wget -q -O - https://composer.github.io/installer.sig)
php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"
ACTUAL_SIGNATURE=$(php -r "echo hash_file('SHA384', 'composer-setup.php');")

if [ "$EXPECTED_SIGNATURE" != "$ACTUAL_SIGNATURE" ]
then
    >&2 output_red "ERROR: Invalid installer signature"
    rm composer-setup.php
    echo 1
fi

php composer-setup.php --quiet
RESULT=$?
rm composer-setup.php
echo $RESULT

output_green "### Install GIT ###"
sudo apt-get -y install git

output_green "### Install python ###"
sudo apt-get -y install python-pip python-dev

output_green "### Install thefuck ###"
sudo pip install psutil thefuck

output_green "### Install htop ###"
sudo apt-get -y install htop

output_green "### Install NodeJs ###"
sudo apt-get -y install nodejs

output_green "### Install VIM ###"
sudo apt-get -y install vim

output_green "### Install Docker ###"
sudo apt-get -y install \
    apt-transport-https \
    ca-certificates \
    software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo apt-key fingerprint 0EBFCD88
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
sudo apt-get update
sudo apt-get -y install docker-ce

output_green "### Install Docker Compose 1.16.0 ###"
sudo curl -L https://github.com/docker/compose/releases/download/1.16.0-rc1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
output_red "### If docker-compose install commad not work , try sudo -i "
output_red " $ curl -L https://github.com/docker/compose/releases/download/1.16.0-rc1/docker-compose-\`uname -s\`-\`uname -m\` > /usr/local/bin/docker-compose"
output_red " $ chmod +x /usr/local/bin/docker-compose "
output_red " $ exit "