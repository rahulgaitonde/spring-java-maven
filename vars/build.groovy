def build(dockerImageName)
    {
        pwd
        sh "docker build -t ${dockerImageName} ."
        echo "Image Got Build ${dockerImageName}"
        sh "docker image"
    }

def run(dockerImageName)
{
    sh "docker run -t --name spring -d ${dockerImageName}"
    sh "docker ps"
    sh "docker cp spring:/app.jar /tmp"
}

