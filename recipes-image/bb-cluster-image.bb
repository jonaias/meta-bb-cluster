#Angstrom bootstrap image
require ${TOPDIR}/sources/meta-angstrom/recipes-images/angstrom/console-image.bb

LICENSE = "GPL"

DEPENDS += "ti-linuxutils \
	    dropbear \
	    mpich \
	    "

IMAGE_INSTALL += "ti-cmem-module \
		  ti-lpm-module\
		  ti-sdma-module\
		  ti-dsplink-module\
		  ti-dsplink-examples\
		  ti-codec-engine-examples\
		  kernel-module-dm9601\
		  dropbear \
		  mpich \
		  task-native-sdk \
		  "

export IMAGE_BASENAME = "bb-cluster-image"
