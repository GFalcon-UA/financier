#!/bin/bash

#
#   Copyright 2016-2022 Oleksii V. KHALIKOV
#
#    Licensed under the Apache License, Version 2.0 (the "License");
#    you may not use this file except in compliance with the License.
#    You may obtain a copy of the License at
#
#        http://www.apache.org/licenses/LICENSE-2.0
#
#    Unless required by applicable law or agreed to in writing, software
#    distributed under the License is distributed on an "AS IS" BASIS,
#    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#    See the License for the specific language governing permissions and
#    limitations under the License.
#

# user needs to change
export PATH=/usr/local/jdk1.8_x64/bin:$PATH
export JAVA_HOME=/usr/local/jdk1.8_x64/bin

if [ $# -lt 1 ]; then
    >&2 echo "usage: $0 /path/to/conf.yaml"
    exit 1
fi

config_file=$1
config_path=$(dirname $1)
name=$(basename $config_path)

export RUNTIME_PATH="$config_path:dist/ibgroup.web.core.iblink.router.clientportal.gw.jar:build/lib/runtime/*"

echo "running $verticle "
echo " runtime path : $RUNTIME_PATH"
echo " verticle     : $verticle"

java -server \
-Dvertx.disableDnsResolver=true \
-Djava.net.preferIPv4Stack=true \
-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.SLF4JLogDelegateFactory \
-Dnologback.statusListenerClass=ch.qos.logback.core.status.OnConsoleStatusListener \
-Dnolog4j.debug=true \
-Dnolog4j2.debug=true \
-cp "${RUNTIME_PATH}" \
ibgroup.web.core.clientportal.gw.GatewayStart
# optional arguments
# -conf conf.beta.yaml --nossl
