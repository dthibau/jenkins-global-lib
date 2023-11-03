// my-shared-library/vars/createTarGz.groovy

def call(Map config) {
    def sourceDir = config.sourceDir
    def extensions = config.extensions
    def outputDir = config.outputDir
    def outputFile = config.outputFile

    echo "Création d'une distribution tar.gz à partir de $sourceDir avec les extensions : ${extensions.join(', ')}"

    // Créez une chaîne de filtres pour rechercher plusieurs extensions
    def extensionFilter = extensions.collect { ext -> "--include=\"*.$ext\"" }.join(' ')

    // Utilisez des commandes shell pour créer le tar.gz
    sh "mkdir -p $outputDir"
    sh "tar -czvf $outputDir/${outputFile}.tar.gz -C $sourceDir $extensionFilter ."
}
