from django.contrib.auth import get_user_model
from django.db import models

# Create your models here.
from django.forms import ModelForm
from django.urls import reverse

User = get_user_model()


class Student(models.Model):
    User_id = models.ForeignKey(User,to_field='id',default=1,on_delete=models.CASCADE)
    name = models.CharField(max_length=50)
    age = models.IntegerField()
    college = models.CharField(max_length=100)

    def get_reverse_url(self):
        # return reverse_lazy("test1:details",kwargs={"pk",self.pk})
        return reverse("std:details",kwargs={"pk":self.pk})
        # return "/detail/{pk}".format(pk=self.pk)


class StdForm(ModelForm):
    class Meta:
        model=Student
        fields="__all__"

