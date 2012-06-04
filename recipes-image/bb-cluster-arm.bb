#Angstrom bootstrap image
require ${TOPDIR}/sources/meta-angstrom/recipes-images/angstrom/console-image.bb

LICENSE = "GPL"

DEPENDS += "dropbear \
	    mpich2 \
	    "

IMAGE_INSTALL += "dropbear \
		  mpich2 \
		  "

export IMAGE_BASENAME = "bb-cluster-image"
