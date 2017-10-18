from django.db import models


class BirthDate(models.Model):

    birthdate = models.DateField()
    
    def __unicode__(self):
    	return unicode(self.birthdate)