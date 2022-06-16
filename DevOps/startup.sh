#!/bin/bash

# exec "git clone https://github.com/ADZD-2021/AZnS.git"
# exec "git checkout devops_dev"
# cd target/
cd /AZnS/DevOps/
BINARY_NAME=$(ls | grep war)
exec gosu root /bin/bash -c "
java -jar {{ BINARY_NAME }}.war
sleep 10
"