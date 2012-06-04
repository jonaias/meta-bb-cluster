DESCRIPTION = "MPICH2 is a high-performance and widely portable implementation of the Message Passing Interface (MPI) standard (both MPI-1 and MPI-2). "
LICENSE = "GPLv2"
HOMEPAGE = "http://www.mcs.anl.gov/research/projects/mpich2/index.php"
SECTION = "console/scientific"

PROVIDES = "mpich2"

SRC_URI = "http://www.mcs.anl.gov/research/projects/mpich2/downloads/tarballs/${PV}/${P}.tar.gz;md5sum=b470666749bcb4a0449a072a18e2c204"


inherit autotools pkgconfig
