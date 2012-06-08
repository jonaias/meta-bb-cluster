#/bin/bash
#  Redistribution and use in source and binary forms, with or without
#  modification, are permitted provided that the following conditions are
#  met:
#  
#  * Redistributions of source code must retain the above copyright
#    notice, this list of conditions and the following disclaimer.
#  * Redistributions in binary form must reproduce the above
#    copyright notice, this list of conditions and the following disclaimer
#    in the documentation and/or other materials provided with the
#    distribution.
#  * Neither the name of the  nor the names of its
#    contributors may be used to endorse or promote products derived from
#    this software without specific prior written permission.
#  
#  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
#  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
#  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
#  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
#  OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
#  SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
#  LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
#  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
#  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
#  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
#  OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#  

critical_source="critical.c"
main_source="main.c"

base_path="/home/tcc/another/setup-scripts/build/tmp-angstrom_v2012_05-eglibc/work/armv7a-angstrom-linux-gnueabi/mpich2-1.5a2-r0/package"

echo "Building DSP critical"
./c6runlib-cc -c $critical_source -o critical_dsp.o
./c6runlib-ar rcs critical_dsp.lib critical_dsp.o

echo "Building ARM critical"
arm-none-linux-gnueabi-gcc -c $critical_source -o critical_arm.o -I$base_path/usr/include/

echo "Building main (always on ARM)"
arm-none-linux-gnueabi-gcc -c $main_source -o main.o -I$base_path/usr/include/

echo "Linking main.o with DSP critical"
arm-none-linux-gnueabi-gcc -I$base_path/usr/include/ -L$base_path/usr/lib/ main.o critical_dsp.lib -o pi_dsp -lmpich -lmpl -lpthread

echo "Linking main.o with ARM critical"
arm-none-linux-gnueabi-gcc -I$base_path/usr/include/ -L$base_path/usr/lib/ main.o critical_arm.o -o pi_arm -lmpich -lmpl 

echo "Building x86 binary"
gcc main.c critical.c -o pi_x86 -lmpich
