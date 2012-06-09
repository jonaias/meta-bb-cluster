#Angstrom bootstrap image
require ${TOPDIR}/sources/meta-angstrom/recipes-images/angstrom/console-image.bb

LICENSE = "GPL"

DEPENDS += "ti-linuxutils \
	    mpich2 \
	    "

IMAGE_INSTALL += "ti-cmem-module \
		  ti-lpm-module\
		  ti-sdma-module\
		  ti-dsplink-module\
		  ti-dsplink-examples\
		  ti-codec-engine-examples\
		  kernel-module-dm9601\
		  mpich2 \
		  task-native-sdk \
		  coreutils\
		  "

export IMAGE_BASENAME = "bb-cluster-image"
