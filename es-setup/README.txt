This directory contains files for populating an elasticsearch index with data required to run the Spark job in the evertrue-test project folder.

first-names.txt: 
a file of common first names, one per line, 10k total (some duplicated)

test.sh: 
-a shell script for inserting documents into elasticsearch. Takes a file as an argument.
-Run like "test.sh first-names.txt"
-Assumes elasticsearch is up and running.
-POSTs to elasticsearch index "customer", type "external"
-Each document is comprised of a single field, "name", where each name value is a first name from first-names.txt (once you've run test.sh to populate)
-leaves unique ID generation up to ES
