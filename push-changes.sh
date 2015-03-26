#!/bin/bash --

git checkout jc
git reset --hard master
cp -r jc/spring-security-4-jc/* jc/spring-security-3-jc/
git add .
git commit -m 'Migrate to Spring Security 4'
git push -f origin jc
git checkout xml
git reset --hard master
cp -r xml/spring-security-4-xml/* xml/spring-security-3-xml/
git add .
git commit -m 'Migrate to Spring Security 4'
git push -f origin xml
git checkout master
git push -f origin master