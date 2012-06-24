#!/bin/bash
echo "Starting tests"
for i in {1..5..1}
  do
     echo "ARM test number $i"
     echo "mpirun -np 1 pi_arm tee - >> results_arm"
     arm-angstrom-linux-gnueabi-mpiexec.hydra -f hosts ./pi_arm tee - >> results_arm
done

for i in {1..5..1}
  do
     echo "DSP test number $i"
     echo "mpirun -np 1 pi_dsp tee - >> results_dsp"
     arm-angstrom-linux-gnueabi-mpiexec.hydra -f hosts ./pi_dsp tee - >> results_dsp
done
