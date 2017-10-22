TARGETS = 1_getpid 2_fork 3_flow 4_mem 5_race 6_wait 7_exec

.PHONY: clean

all: $(TARGETS)

%: %.c
	gcc $< -o $@

clean:
	rm -f $(TARGETS)
