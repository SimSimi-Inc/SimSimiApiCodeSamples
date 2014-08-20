# -*- coding: utf- -*-

import urllib
import urllib2

url = "http://sandbox.api.simsimi.com/request.p?"

text_input = raw_input("Input your text: ")
lc_input = raw_input("Input your lc: ")
text = text_input.encode("utf-8")
lc = lc_input.encode("utf-8")
values = {'key' : 'd6bbfd1b-7cb3-4cfe-87b1-261e4d210d19',
          'lc' : lc,
          'ft' : '0.0',
	  'text' : text}

data = urllib.urlencode(values)
request_url = urllib2.Request(url, data)
response_post = urllib2.urlopen(request_url)
response = response_post.read().decode("utf-8")
print response
