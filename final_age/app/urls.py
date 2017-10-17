from django.conf.urls import url, include
from . import views

urlpatterns = [
    #url(r'^app/', include('app.urls')),
    url(r'^$', views.fun, name='fun'),
    url(r'^add_birthdate/$', views.add_birthdate, name='add_birthdate'),
    url(r'^fun/$', views.fun, name='fun'),
]