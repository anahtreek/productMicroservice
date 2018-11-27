node {
        stage('checkin code') {
                sh '''ssh rig@52.168.175.97 "sudo git clone https://github.com/anahtreek/productMicroservice.git;cd productMicroservice"'''
           }
        stage('Build') {
                sh 'ssh rig@52.168.175.97 "cd productMicroservice;mvn install -DskipTests"'          
        }
}
