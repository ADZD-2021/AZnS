#!/bin.bash

exec gosu root /bin/bash -c "
java -jar {{ binary_name }}.war
sleep 10
"