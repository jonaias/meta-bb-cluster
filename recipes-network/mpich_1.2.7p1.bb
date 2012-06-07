DESCRIPTION = "MPICH is a freely available, portable implementation of MPI, the Standard for message-passing libraries."
LICENSE = "CLOSED"
HOMEPAGE = "http://www.mcs.anl.gov/research/projects/mpi/mpich1-old/"
SECTION = "console/scientific"

PROVIDES = "mpi"

RDEPENDS = "ssh"

EXTRA_OECONF = "--with-device=ch_p4 -disable-long-double--disable-f77" 


SRC_URI = "ftp://ftp.mcs.anl.gov/pub/mpi/mpich-1.2.7p1.tar.gz;md5sum=7a4ac672b4b358ce519a93b70f771bee"


inherit autotools pkgconfig


do_configure() {
    oe_runconf
}

do_install () {
    autotools_do_install
}