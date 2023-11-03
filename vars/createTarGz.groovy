// my-shared-library/vars/createTarGz.groovy

def call(Map config) {
    def sourceDir = config.sourceDir
    def extensions = config.extensions
    def outputDir = config.outputDir
    def outputFile = config.outputFile

    echo "Création d'une distribution tar.gz à partir de $sourceDir avec les extensions : ${extensions.join(', ')}"


    // Utilisez des commandes shell pour créer le tar.gz
    sh "mkdir -p $outputDir"
    sh "find $sourceDir -type f -name '*.${extensions.join("' -o -name *.'")}' | tar -czvf $outputDir/${outputFile}.tar.gz -T -"
}
