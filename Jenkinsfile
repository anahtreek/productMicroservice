node {
        stage('Checkin Code') {
                sh '''ssh rig@52.168.175.97 "sudo rm -rf productMicroservice;sudo git clone https://github.com/anahtreek/productMicroservice.git;cd productMicroservice"'''
           }
        stage('Build') {
                sh 'ssh rig@52.168.175.97 "cd productMicroservice;sudo mvn install -DskipTests"'          
        }
        stage('Push to CF') {
                sh 'ssh rig@52.168.175.97 "cf login -a https://api.system.dev.pcf-aws.com -u keerthana.n10@wipro.com -p Indian@123 -o Pcf-training -s training;cd productMicroservice;cf push --no-start -n productMicroservice"'          
        }
        stage('Create and Bind Service') {
                sh 'ssh rig@52.168.175.97 "cf create-service p.mysql db-small  myservice;cf bind-service product  myservice"'          
        }
        stage('Start app') {
                sh 'ssh rig@52.168.175.97 "cf start product"'          
        }
}
