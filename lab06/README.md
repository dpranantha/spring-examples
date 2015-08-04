JMS client implementation using ActiveMQ. 
You can run ActiveMQ via docker as well.
If you run boot2docker in macOSX, you need to expose the port by executing the following (for instance):
VBoxManage controlvm boot2docker-vm natpf1 "activemq_queue,tcp,127.0.0.1,61616,,61616"
VBoxManage controlvm boot2docker-vm natpf1 "activemq,tcp,127.0.0.1,8161,,8161"
