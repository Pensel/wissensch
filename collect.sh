SAVELOCATION="/media/data/collection/"
CLASSPATH="/media/data/gits/StudiumNow/WA/Code/out/production/Code"
DURATION="2m"
timeout $DURATION java -cp $CLASSPATH Test PRE >> $SAVELOCATION/collectPRE
timeout $DURATION java -cp $CLASSPATH Test POST >> $SAVELOCATION/collectPOST
grep "D" $SAVELOCATION/collectPRE > $SAVELOCATION/d.pre
grep "B" $SAVELOCATION/collectPRE > $SAVELOCATION/b.pre
grep "D" $SAVELOCATION/collectPOST > $SAVELOCATION/d.post
grep "B" $SAVELOCATION/collectPOST > $SAVELOCATION/b.post

sed "s/B//" $SAVELOCATION/b.pre > $SAVELOCATION/b.pre.data
sed "s/D//" $SAVELOCATION/d.pre > $SAVELOCATION/d.pre.data
sed "s/B//" $SAVELOCATION/b.post > $SAVELOCATION/b.post.data
sed "s/D//" $SAVELOCATION/d.post > $SAVELOCATION/d.post.data

cat $SAVELOCATION/b.pre.data | datamash median 1 > $SAVELOCATION/b.pre.res
cat $SAVELOCATION/d.pre.data | datamash median 1 > $SAVELOCATION/d.pre.res
cat $SAVELOCATION/b.post.data | datamash median 1 > $SAVELOCATION/b.post.res
cat $SAVELOCATION/d.post.data | datamash median 1 > $SAVELOCATION/d.post.res

echo "BPRE:" >> $SAVELOCATION/final.res
cat $SAVELOCATION/b.pre.res >> $SAVELOCATION/final.res
echo "DPRE:" >> $SAVELOCATION/final.res
cat $SAVELOCATION/d.pre.res >> $SAVELOCATION/final.res

echo "BPOST:" >> $SAVELOCATION/final.res
cat $SAVELOCATION/b.post.res >> $SAVELOCATION/final.res
echo "DPOST:" >> $SAVELOCATION/final.res
cat $SAVELOCATION/d.post.res >> $SAVELOCATION/final.res

