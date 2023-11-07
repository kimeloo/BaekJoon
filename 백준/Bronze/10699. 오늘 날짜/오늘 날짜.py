from datetime import datetime, timezone, timedelta
kst = timezone(timedelta(hours=9))
a = str(datetime.now(kst).strftime('%Y-%m-%d'))
print(a)