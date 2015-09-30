while read p; do
  curl -XPOST 'localhost:9200/customer/external?pretty' -d '{"name": "'"$p"'"}'
done
