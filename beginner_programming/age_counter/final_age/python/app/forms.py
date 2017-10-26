from django import forms
from django.forms import ModelForm

from .models import BirthDate


class DateInput(forms.DateInput):
    input_type = 'date'


class MainForm(ModelForm):

    class Meta:
        model = BirthDate
        fields = ['birthdate']
        widgets = {
            'birthdate': DateInput(),
        }