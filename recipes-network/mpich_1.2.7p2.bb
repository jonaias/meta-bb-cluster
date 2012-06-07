DESCRIPTION = "MPICH is a freely available, portable implementation of MPI, the Standard for message-passing libraries."
LICENSE = "CLOSED"
HOMEPAGE = "http://www.mcs.anl.gov/research/projects/mpi/mpich1-old/"
SECTION = "console/scientific"

PROVIDES = "mpi"

RDEPENDS = "ssh"

SRC_URI = "ftp://ftp.mcs.anl.gov/pub/mpi/mpich-1.2.7p2.tar.gz;md5sum=e3aff3f9bb3293b3dd5467184a4f5353"


inherit autotools pkgconfig

do_configure () {
    ./configure --with-device=ch_p4 -disable-long-double--disable-f77 -rsh=ssh
}

do_install () {
    autotools_do_install
}