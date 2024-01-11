# Тестирование балансировщика

При нагрузочном тестировании в обоих случаях делалось 500 запросов, которые были разбиты по 20 единовременно 
конкурирующих запросов

## Без балансировщика

Server Hostname:        localhost \
Server Port:            8080

Document Path:          /catalog/cakes \
Document Length:        1262 bytes

Concurrency Level:      20 \
Time taken for tests:   4.426 seconds \
Complete requests:      500 \
Failed requests:        0 \
Total transferred:      774500 bytes \
HTML transferred:       631000 bytes \
Requests per second:    112.97 [#/sec] (mean) \
Time per request:       177.042 [ms] (mean) \
Time per request:       8.852 [ms] (mean, across all concurrent requests) \
Transfer rate:          170.89 [Kbytes/sec] received

Connection Times (ms) \
min  mean[+/-sd] median   max \
Connect:        0    0   0.2      0       1 \
Processing:    35  173  38.9    170     371 \
Waiting:       33  172  38.8    169     365 \
Total:         35  173  38.9    170     371

Percentage of the requests served within a certain time (ms) \
50%    170 \
66%    183 \
75%    191 \
80%    199 \
90%    216 \
95%    235 \
98%    279 \
99%    291 \
100%    371 (longest request)

## С балансировщиком

Server Software:        nginx/1.25.2 \
Server Hostname:        localhost \
Server Port:            80

Document Path:          /catalog/cakes \
Document Length:        153 bytes

Concurrency Level:      20  \
Time taken for tests:   2.077 seconds \
Complete requests:      500 \
Failed requests:        0 \
Non-2xx responses:      500 \
Total transferred:      151500 bytes \
HTML transferred:       76500 bytes \
Requests per second:    240.68 [#/sec] (mean) \
Time per request:       83.099 [ms] (mean) \
Time per request:       4.155 [ms] (mean, across all concurrent requests) \
Transfer rate:          71.22 [Kbytes/sec] received

Connection Times (ms) \
min  mean[+/-sd] median   max \
Connect:        0    0   0.2      0       2 \
Processing:     1    2   0.8      2       6 \
Waiting:        0    1   0.7      1       5 \
Total:          1    2   0.8      2       7

Percentage of the requests served within a certain time (ms) \
50%      2 \
66%      2 \
75%      2 \
80%      2 \
90%      3 \
95%      3 \
98%      4 \
99%      5 \
100%      7 (longest request)

