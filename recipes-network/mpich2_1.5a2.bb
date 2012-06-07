DESCRIPTION = "MPICH2 is a high-performance and widely portable implementation of the Message Passing Interface (MPI) standard (both MPI-1 and MPI-2). "
LICENSE = "CLOSED"
HOMEPAGE = "http://www.mcs.anl.gov/research/projects/mpich2/index.php"
SECTION = "console/scientific"

PROVIDES = "mpi"

RDEPENDS = "ssh"

EXTRA_OECONF = "--with-device=ch3:sock --disable-f77 --disable-fc" 


#LIC_FILES_CHKSUM = “file://COPYRIGHT;md5=f821bfe211bf0d0c5c9b3c49cc5ceddc"


SRC_URI = "http://www.mcs.anl.gov/research/projects/mpich2/downloads/tarballs/${PV}/${P}.tar.gz;md5sum=8be7521600b69b18b9804bd842c661e0"



inherit autotools pkgconfig


do_configure() {
    oe_runconf
}

do_install () {
    mkdir -p "${D}/usr/bin"
    mkdir "${D}/etc"
    mkdir -p "${D}/usr/share/man/man4"
    autotools_do_install
}