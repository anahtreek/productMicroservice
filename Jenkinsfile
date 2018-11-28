node {
        stage('Checkin Code') {
                sh '''ssh rig@52.168.175.97 "cd productMicroservice;sudo git fetch --all;sudo git reset --hard origin/master"'''
           }
        stage('Build') {
                sh 'ssh rig@52.168.175.97 "cd productMicroservice;sudo mvn install -DskipTests"'          
        }
        stage('Push to CF') {
                sh 'ssh rig@52.168.175.97 "cf login -a https://api.system.dev.pcf-aws.com -u keerthana.n10@wipro.com -p Indian@123 -o Pcf-training -s training;cd productMicroservice;cf push --no-start -n productmicroservice"'          
        }
        stage('Create and Bind Service') {
                sh 'ssh rig@52.168.175.97 "cf create-service p.mysql db-small  myservice;cf bind-service product  myservice"'          
        }
        stage('Start app') {
                sh 'ssh rig@52.168.175.97 "cf start product"'          
        }
        
        stage('Smoke test') {
                sh '''ssh rig@52.168.175.97 "export POST_URL=https://productmicroservice.apps.dev.pcf-aws.com/product;curl -X POST -H 'content-type: application/json;charset=UTF-8' -d '{"productName":"HD SetupBox", "serviceId":"100"}' '$POST_URL' > response;grep '\"serviceId\":\"100\"' 'response';if [ $? -ne 0 ];then exit 1; fi"'''          
        }
}
