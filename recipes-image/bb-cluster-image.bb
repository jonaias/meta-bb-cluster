#Angstrom bootstrap image
require ${TOPDIR}/sources/meta-angstrom/recipes-images/angstrom/console-image.bb

LICENSE = "GPL"

DEPENDS += "ti-linuxutils \
	    dropbear \
	    mpich2 \
	    task-native-sdk \
	    "

IMAGE_INSTALL += "ti-cmem-module \
		  ti-linuxutils-app\
		  ti-sdma-module\
		  dropbear \
		  mpich2 \
		  task-native-sdk \
		  "

export IMAGE_BASENAME = "bb-cluster-image"
