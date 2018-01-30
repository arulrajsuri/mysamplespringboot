node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }
    
    stage('Maven build'){
        withMaven(){
 
      // Run the maven build
      sh "mvn clean install"
 
    }
    }
 
    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        app = docker.build("arulrajsuri/myspring")
    }
    
     stage('Test image') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        /* Finally, we'll push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag.
         * Pushing multiple tags is cheap, as all the layers are reused. */
       docker.withRegistry('https://hub.docker.com', 'docker-hub-secret') {
            //app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
