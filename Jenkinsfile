 node {
        stage('checkin code') {
                sh '''ssh rig@52.168.175.97 "rm -rf productMicroservice;sudo git clone https://github.com/anahtreek/productMicroservice.git;"'''
           }
        stage('Build') {
                sh 'ssh rig@52.168.175.97 "cd productMicroservice;mvn install -DskipTests;cf login -a https://api.system.dev.pcf-aws.com -u keerthana.n10@wipro.com -p Indian@123 -o Pcf-training -s training"'          
        }
        stage("Deploy To Pcf") {
                sh 'ssh rig@52.168.175.97 "cd productMicroservice;cf push --no-start -n productMicroservice;cf create-service p.mysql db-small  myservice;cf bind-service product  myservice;cf start product;"'
    }
}
