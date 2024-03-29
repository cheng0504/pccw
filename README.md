# pccw

Web driver:
1. Download the latest chrome driver and rename it with 'chromedriver' if necessary.
2. Put the chrome driver to ‘/webdriver’ folder.

Config:
1. All the configuration is saved in '/src/main/resources/config.json' file and in json format.
2. "VISIT_RESULT" is used to specify which image needs to be selected. Start counting from 1.
3. "SOURCE_FILE_NAME" is used to specify the source image name for retrieval.

Where to place the source file:
1. The source image file should be placed in folder '/src/main/resources/'.

How to start:
1. Download all the Maven dependencies in pom.xml.
2. The program entrance could be found in 'main' function.

Output:
1. The latest visited website's snapshot will be put in folder '/src/main/resources/' and named with 'screenshot.png'.
2. The image similarity percentage between the source image and the snapshot image will be printed out in IDE console.
